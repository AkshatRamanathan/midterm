package midterm.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import midterm.model.Movie;

public class MovieDAO {

	private MongoCollection<Document> mongoCollectionMovies;

	public MovieDAO(MongoClient mongo) {
		this.mongoCollectionMovies = mongo.getDatabase("midterm").getCollection("movies");
	}

	public Movie create(Movie movie) {
		Document movieDoc = MovieConvertor.toDocument(movie);
		this.mongoCollectionMovies.insertOne(movieDoc);
		ObjectId _id = (ObjectId) movieDoc.get("_id");
		movie.set_id(_id);
		return movie;
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		MongoCursor<Document> cursor = mongoCollectionMovies.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				Movie movie = MovieConvertor.toMovie(doc);
				movies.add(movie);
			}
		} finally {
			cursor.close();
		}
		return movies;
	}

	public void update(Movie movie) {
	        this.mongoCollectionMovies.updateOne(Filters.eq("_id", movie.get_id()), new Document("$set", MovieConvertor.toDocument(movie)));
	    }

	public void delete(ObjectId _id) {
		this.mongoCollectionMovies.deleteOne(Filters.eq("_id", _id));
	}

	public boolean exists(ObjectId _id) {
		FindIterable<Document> doc = this.mongoCollectionMovies.find(Filters.eq("_id", _id)).limit(1);
		return doc != null;
	}

	public Movie getMovie(String id) {
		ObjectId _id=new ObjectId(id);
		Document doc = this.mongoCollectionMovies.find(Filters.eq("_id", _id)).first();
		return MovieConvertor.toMovie(doc);
	}
}
