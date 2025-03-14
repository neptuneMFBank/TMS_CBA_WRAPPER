// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: easypay.proto

package com.neptune.cba.transaction.easy_pay;

public interface EasyPayListResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.neptune.cba.EasyPayListResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.neptune.cba.EasyPayRequest easypays = 1;</code>
   */
  java.util.List<com.neptune.cba.transaction.easy_pay.EasyPayRequest> 
      getEasypaysList();
  /**
   * <code>repeated .com.neptune.cba.EasyPayRequest easypays = 1;</code>
   */
  com.neptune.cba.transaction.easy_pay.EasyPayRequest getEasypays(int index);
  /**
   * <code>repeated .com.neptune.cba.EasyPayRequest easypays = 1;</code>
   */
  int getEasypaysCount();
  /**
   * <code>repeated .com.neptune.cba.EasyPayRequest easypays = 1;</code>
   */
  java.util.List<? extends com.neptune.cba.transaction.easy_pay.EasyPayRequestOrBuilder> 
      getEasypaysOrBuilderList();
  /**
   * <code>repeated .com.neptune.cba.EasyPayRequest easypays = 1;</code>
   */
  com.neptune.cba.transaction.easy_pay.EasyPayRequestOrBuilder getEasypaysOrBuilder(
      int index);

  /**
   * <code>int64 totalItems = 2;</code>
   * @return The totalItems.
   */
  long getTotalItems();

  /**
   * <code>int64 totalPages = 3;</code>
   * @return The totalPages.
   */
  long getTotalPages();

  /**
   * <code>int64 currentPages = 4;</code>
   * @return The currentPages.
   */
  long getCurrentPages();
}
