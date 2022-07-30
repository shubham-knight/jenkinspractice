package org.sapient.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import org.sapient.facades.MovieFacade;
import org.sapient.helpers.MongoDBHelper;
import org.sapient.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class MovieImpl implements MovieFacade{
    private MongoClient mongoClient;
    private MongoCollection mongoCollection;
    private ResourceBundle resourceBundle;
    private boolean status;
    private Gson gson;

    public MovieImpl() {
        resourceBundle=ResourceBundle.getBundle("db");
        mongoClient= MongoDBHelper.getConnection();
        var database= mongoClient
                .getDatabase(resourceBundle.getString("dbname"));
        var collectionName=resourceBundle.getString("collectionName");
        if(database.getCollection(collectionName)==null) {
            database.createCollection(collectionName);
        }
        mongoCollection= database.getCollection(collectionName);
        mongoCollection.createIndex(Indexes.ascending("movieCode","movieCode"));
        gson=new Gson();
    }

    @Override
    public boolean addMovie(Movie movie) {
        Document document= Document.parse(gson.toJson(movie));
        mongoCollection.insertOne(document);
        status=true;
        return status;
    }

    @Override
    public boolean updateMovie(String movieCode, String movieName) {
        mongoCollection.updateOne(new Document("movieCode",movieCode),
                new Document("$set",new Document("movieName",movieName)));
        status=true;
        return status;
    }

    @Override
    public List<Object> getAllMovies() {
        ArrayList<Object> movies=new ArrayList<>();
        try(MongoCursor<Document> cursor= mongoCollection.find()
                .sort(new Document("movieCode",1)).limit(1)
                .iterator()){
            while(cursor.hasNext()){
                var doc=cursor.next();
                movies.add(doc.values());
            }
        }
        return movies;
    }

    @Override
    public boolean deleteMovieByCode(String movieCode) {
        mongoCollection.deleteOne(eq("movieCode",movieCode));
        status=true;
        return status;    }
}
