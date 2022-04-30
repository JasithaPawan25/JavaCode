package business;

public class Module {
    private int moduleID;
    private String mTiltle;

    public Module() {
    }

    public Module(int moduleID, String mTiltle) {
        this.moduleID = moduleID;
        this.mTiltle = mTiltle;
    }

    public int getModuleID() { //encapsulation
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getmTiltle() {
        return mTiltle;
    }

    public void setmTiltle(String mTiltle) {
        this.mTiltle = mTiltle;
    }  
}
