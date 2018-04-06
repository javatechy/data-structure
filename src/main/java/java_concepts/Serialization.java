
package java_concepts;

import static utils.Common.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Demo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1919199191928838L;
	public int a;
	public String b;

	// Default constructor
	public Demo(int a, String b) {
		this.a = a;
		this.b = b;
	}

}

public class Serialization {
	public static void main(String[] args) {
		Demo object = new Demo(1, "deepak");
		String filename = "file.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			println("Object has been serialized");

		} catch (IOException ex) {
			println("IOException is caught");
		}

		Demo object1 = null;

		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object1 = (Demo) in.readObject();

			in.close();
			file.close();

			println("Object has been deserialized ");
			println("a = " + object1.a);
			println("b = " + object1.b);
		} catch (IOException ex) {
			println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			println("ClassNotFoundException is caught");
		}

	}
}
