package com.example.myappim;

import java.io.Serializable;

public class MyContact  {
  private String name;
  private int offerK;
  private int txtFi;
  private int txtPriceNoOffer;
  private int txtPriceOffer;
  private int txtNumber;
  private int sodSell;



  public MyContact(String name, int offerK,int txtFi,int txtPriceNoOffer, int txtPriceOffer,int txtNumber,int sodSell) {
    this.name = name;
    this.offerK = offerK;
    this.txtFi = txtFi;
    this.txtPriceNoOffer = txtPriceNoOffer;
    this.txtPriceOffer = txtPriceOffer;
    this.txtNumber = txtNumber;
    this.sodSell = sodSell;


  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }

  public int getOfferK() {
    return offerK;
  }

  public void setOfferK(int offerK) {
    this.offerK = offerK;
  }


  public int getTxtFi() {
    return txtFi;
  }

  public int getTxtPriceNoOffer() {
    return txtPriceNoOffer;
  }

  public int getTxtPriceOffer() {
    return txtPriceOffer;
  }

  public int getTxtNumber() {
    return txtNumber;
  }

  public void setTxtFi(int txtFi) {
    this.txtFi = txtFi;
  }

  public void setTxtPriceNoOffer(int txtPriceNoOffer) {
    this.txtPriceNoOffer = txtPriceNoOffer;
  }

  public void setTxtPriceOffer(int txtPriceOffer) {
    this.txtPriceOffer = txtPriceOffer;
  }

  public void setTxtNumber(int txtNumber) {
    this.txtNumber = txtNumber;
  }

  public int getSodSell() {
    return sodSell;
  }

  public void setSodSell(int sodSell) {
    this.sodSell = sodSell;
  }
}
