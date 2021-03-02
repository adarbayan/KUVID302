package Domain;

//import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
//import com.mongodb.MongoClientSettings;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import static com.mongodb.client.model.Filters.eq;

public class MongoDataBase {
	public static ArrayList<Atoms> savedAtoms;
	public static ArrayList<Molecule> savedMolecules;
	public static ArrayList<ReactionBlocker> savedReactionBlockers;
	public static ArrayList<PowerUp> savedPowerUps;
	public static ArrayList<int[]> savedNumberOfMolecules;
	public static int[] numberOfGameObjects;

	ArrayList<int[]> moleculeSavedArray = new ArrayList<int[]>();

	ArrayList<int[]> reactionBlockerSavedArray = new ArrayList<int[]>();
	ArrayList<int[]> PowerUpsSavedArray = new ArrayList<int[]>();
	ArrayList<int[]> numberOfGameObjectsSavedArray = new ArrayList<int[]>();

	static ArrayList<int[]> moleculeArray = new ArrayList<int[]>();
	static ArrayList<double[]> atomArray = new ArrayList<double[]>();
	static ArrayList<int[]> reactionBlockerArray = new ArrayList<int[]>();
	static ArrayList<int[]> PowerUpsArray = new ArrayList<int[]>();
	static ArrayList<int[]> numberOfGameObjectsArray = new ArrayList<int[]>();

	public static void main(String[] args) {

		// Mongo Connection setup
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE); // e.g. or Log.WARNING, etc.
		MongoClient mongoClient = MongoClients
				.create("mongodb+srv://comp302_user:comp302_password@sandbox.v2mqr.mongodb.net/"); // uri connection to
																									// the server
		MongoDatabase database = mongoClient.getDatabase("Comp302"); // selecting the database
		MongoCollection<Document> collection = database.getCollection("mardatone"); // collection
		// creating a document to save in the collection
		int count = 0;
		Document doc = new Document();
		for (Molecule m : savedMolecules) {
			count++;
			int[] a = { m.getxPos(), m.getyPos(), m.getLength(), m.getWidth(), m.getType(), (int) m.getySpeed() };
			List<String> listMol = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				listMol.add(Integer.toString(a[i]));
				doc.append("molecule" + count, listMol);
			}
		}
		for (Atoms a : savedAtoms) {
			count++;
			double[] b = { a.getxPos(), a.getyPos(), a.getLength(), a.getWidth(), a.getNeutron(), a.getProton(),
					a.calculateEfficiency(), a.getxSpeed(), a.getySpeed() };
			List<String> listMol = new ArrayList<>();
			for (int i = 0; i < b.length; i++) {
				listMol.add(Double.toString(b[i]));
				doc.append("atom" + count, listMol);
			}
		}
		for (ReactionBlocker r : savedReactionBlockers) {
			count++;
			int[] c = { r.getxPos(), r.getyPos(), r.getLength(), r.getWidth(), r.getType(), (int)r.getySpeed() };
			List<String> listMol = new ArrayList<>();
			for (int i = 0; i < c.length; i++) {
				listMol.add(Double.toString(c[i]));
				doc.append("ReactionBlockers" + count, listMol);
			}
		}
		for (PowerUp d : savedPowerUps) {
			count++;
			int[] c = { d.getXpos(), d.getYpos(), d.getRadius(), d.getType(), (int) d.getySpeed() };
			List<String> listMol = new ArrayList<>();
			for (int i = 0; i < c.length; i++) {
				listMol.add(Double.toString(c[i]));
				doc.append("PowerUps" + count, listMol);
		}
		}
		for (int[] d : savedNumberOfMolecules) {
			count++;
			int[] c = d;
			List<String> listMol = new ArrayList<>();
			for (int i = 0; i < c.length; i++) {
				listMol.add(Double.toString(c[i]));
				doc.append("NumberOfMolecules" + count, listMol);
		}
		}

		/*
		 * //dumping game info to the collection
		 * 
		 * doc.append("username", game.p_user_name); doc.append("level", game.level);
		 * doc.append("score", 20); doc.append("atoms", game.atoms);
		 * doc.append("coordinates", new Document("x", game.position_x).append("y",
		 * game.position_y));
		 */
		// saving document to the collection i.e., KuvidCollection
		collection.insertOne(doc);

		// finding the document: 1st way
		Document my_doc = collection.find().first();
		System.out.println(my_doc.toJson()); // printing whole document
		System.out.println(my_doc.get("molecule")); // pringint only the username
		/*
		 * // 2nd way: by user my_doc = collection.find(eq("username", "u1")).first();
		 * System.out.println(my_doc.toJson()); // printing whole document my_doc =
		 * collection.find(eq("username", "u2")).first(); // since there is no user with
		 * u2 username the result will be empy try {
		 * System.out.println(my_doc.toJson()); // printing whole document } catch
		 * (NullPointerException e) { System.out.println(e); }
		 */
		/*
		 * // delete one document Bson filter = eq("username", "u1"); DeleteResult
		 * result = collection.deleteOne(filter); System.out.println(result);
		 */

	}

}
