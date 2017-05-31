package com.alford.grappler;

/**
 * Created by WilliamAlford on 4/8/17.
 */

public class Positions {

    public Positions(){

    }


//    public Positions(long mId, String mPositionName, String mDescription, String mImageBig, String mImageSmall, boolean mDefensive, boolean mOffensiive, int mCost) {
//        this.mId = mId;
//        this.mPositionName = mPositionName;
//        this.mDescription = mDescription;
//        this.mImageBig = mImageBig;
//        this.mImageSmall = mImageSmall;
//        this.mDefensive = mDefensive;
//        this.mOffensiive = mOffensiive;
//        this.mCost = mCost;
//
//    }




    private long mId;

    private String mPositionName;

    public Positions(long mId, String mPositionName, String mDescription, String mImageBig, String mImageSmall, boolean mDefensive, boolean mOffensiive, int mCost, int mQuantity) {
        this.mId = mId;
        this.mPositionName = mPositionName;
        this.mDescription = mDescription;
        this.mImageBig = mImageBig;
        this.mImageSmall = mImageSmall;
        this.mDefensive = mDefensive;
        this.mOffensiive = mOffensiive;
        this.mCost = mCost;
        this.mQuantity = mQuantity;
    }

    private String mDescription;
    private String mImageBig;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmPositionName() {
        return mPositionName;
    }

    public void setmPositionName(String mPositionName) {
        this.mPositionName = mPositionName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImageBig() {
        return mImageBig;
    }

    public void setmImageBig(String mImageBig) {
        this.mImageBig = mImageBig;
    }

    public String getmImageSmall() {
        return mImageSmall;
    }

    public void setmImageSmall(String mImageSmall) {
        this.mImageSmall = mImageSmall;
    }

    public boolean ismDefensive() {
        return mDefensive;
    }

    public void setmDefensive(boolean mDefensive) {
        this.mDefensive = mDefensive;
    }

    public boolean ismOffensiive() {
        return mOffensiive;
    }

    public void setmOffensiive(boolean mOffensiive) {
        this.mOffensiive = mOffensiive;
    }

    public int getmCost() {
        return mCost;
    }

    public void setmCost(int mCost) {
        this.mCost = mCost;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    private String mImageSmall;
    private boolean mDefensive, mOffensiive;
    private int mCost,mQuantity;




}
