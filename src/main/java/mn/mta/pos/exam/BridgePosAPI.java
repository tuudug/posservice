package mn.mta.pos.exam;

public class BridgePosAPI {
    static{
        String os = System.getProperty("os.name");
        if (os.toUpperCase().contains("WINDOWS")) {
            System.loadLibrary("icudt53");
            System.loadLibrary("icuuc53");
            System.loadLibrary("icuin53");
            System.loadLibrary("Qt5Core");
            System.loadLibrary("Qt5SQL");
            System.loadLibrary("Qt5Network");
            System.loadLibrary("PosAPI");
            System.loadLibrary("sqlite3");
            System.loadLibrary("ssleay32");
        }
        System.loadLibrary("BridgePosAPI");
    }
    public static native String put(String data);

    public static native String returnBill(String data);
    
    public static native String sendData();

    public static native String checkAPI();

    public static native String getInformation();

    public static native String callFunction(String funcName, String data);
}