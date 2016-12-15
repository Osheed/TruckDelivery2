package com.example.marc.truckdelivery;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

import db.adapter.DeliveryDataSource;
import db.object.DeliveryObject;

public class dr_delivery2 extends AppCompatActivity {

    Context context;
    Bundle bundle;
    Integer RDeliveryID;
    DeliveryDataSource dts;
    DeliveryObject delivery;
    TextView dr_delivery_course2;
    TextView dr_delivery_date2;
    TextView dr_delivery_quantity2;
    TextView dr_delivery_conditioning2;
    TextView dr_delivery_commodity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_delivery2);
        context = this;

        /**
         * Add additional functions to actionbar
         */
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.drawable.ic_launcher);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6C7CE2")));

        dts = new DeliveryDataSource(this);

        /*
         *Recuperation des valeurs en sécurité
         */
        if(savedInstanceState==null) {
            bundle = getIntent().getExtras();
            if (bundle == null) {
                RDeliveryID = null ;
            } else {
                RDeliveryID = bundle.getInt("idDelivery") ;
            }
        }else{
            RDeliveryID = (int)savedInstanceState.getSerializable("idDelivery");
        }


        //Get the Delivery and fill the textviews
        delivery = dts.getDeliveryById(RDeliveryID);

        dr_delivery_course2 = (TextView)findViewById(R.id.dr_delivery_course2);
        dr_delivery_course2.setText(""+delivery.getId());
        dr_delivery_date2 = (TextView)findViewById(R.id.dr_delivery_date2);
        dr_delivery_date2.setText(delivery.getDate());
        dr_delivery_quantity2 = (TextView)findViewById(R.id.dr_delivery_quantity2);
        dr_delivery_quantity2.setText(""+delivery.getQuantity());
        dr_delivery_conditioning2 = (TextView)findViewById(R.id.dr_delivery_conditioning2);
        dr_delivery_conditioning2.setText(delivery.getConditioning());
        dr_delivery_commodity2 = (TextView)findViewById(R.id.dr_delivery_commodity2);
        dr_delivery_commodity2.setText(delivery.getArticle());

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()) {
            case R.id.id_enFlag:
                LocaleHelper.setLocale(this,"en");
                updateViews();
                break;
            case R.id.id_frFlag:
                LocaleHelper.setLocale(this,"fr");
                updateViews();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                Intent back = new Intent(this,LoginPage.class);
                startActivity(back);
                finish();
            default:
                LocaleHelper.setLocale(this,"en");
                updateViews();
                break;
        }
        return true;
    }
    private void updateViews() {
        Resources resources = getResources();
        dr_delivery_course2 = (TextView)findViewById(R.id.dr_delivery_course2);
        dr_delivery_course2.setText(delivery.getId());
        dr_delivery_date2 = (TextView)findViewById(R.id.dr_delivery_date2);
        dr_delivery_date2.setText(delivery.getDate());
        dr_delivery_quantity2 = (TextView)findViewById(R.id.dr_delivery_quantity2);
        dr_delivery_quantity2.setText(delivery.getQuantity());
        dr_delivery_conditioning2 = (TextView)findViewById(R.id.dr_delivery_conditioning2);
        dr_delivery_conditioning2.setText(delivery.getConditioning());
        dr_delivery_commodity2 = (TextView)findViewById(R.id.dr_delivery_commodity2);
        dr_delivery_commodity2.setText(delivery.getArticle());

    }
}
