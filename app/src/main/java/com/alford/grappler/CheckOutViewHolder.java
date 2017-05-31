package com.alford.grappler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WilliamAlford on 4/10/17.
 */

public class CheckOutViewHolder extends RecyclerView.ViewHolder {
    View mRootView;
    ImageView mItemImageLogoBig;
    TextView mPositonDescriptionTextView;
    TextView mPostionNameTextView;
    TextView mPositionCostTextView;

    ImageView mPlaceInCartImageButton;

    Button mClearShoppingCartButton;

    Button mRemoveThisParticular;








    public CheckOutViewHolder(View itemView) {
        super(itemView);

        mRootView = itemView;

        mItemImageLogoBig = (ImageView) itemView.findViewById(R.id.item_logo);
        mPostionNameTextView = (TextView) itemView.findViewById(R.id.item_name);
        mPositonDescriptionTextView = (TextView) itemView.findViewById(R.id.item_description);
        mPositionCostTextView = (TextView) itemView.findViewById(R.id.payment);

        mPlaceInCartImageButton = (ImageView) itemView.findViewById(R.id.buy_button);

        mClearShoppingCartButton = (Button) itemView.findViewById(R.id.final_purchase);

        mRemoveThisParticular = (Button) itemView.findViewById(R.id.remover);


    }
}
