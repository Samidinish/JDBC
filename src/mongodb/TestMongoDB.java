package mongodb;

public class TestMongoDB {

	public static void main(String[] args) {
		ConnectMongoDB mongo = new ConnectMongoDB();
		mongo.connectMongo("TestCollections");
		mongo.insert("NewsContent", "Tech", "Steve Job");

	}

}