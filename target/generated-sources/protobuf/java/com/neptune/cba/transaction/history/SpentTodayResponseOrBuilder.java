// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: history.proto

package com.neptune.cba.transaction.history;

public interface SpentTodayResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.neptune.cba.SpentTodayResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>double totaldebit = 1;</code>
   * @return The totaldebit.
   */
  double getTotaldebit();

  /**
   * <code>double totalcredit = 2;</code>
   * @return The totalcredit.
   */
  double getTotalcredit();

  /**
   * <code>int32 responseCode = 3;</code>
   * @return The responseCode.
   */
  int getResponseCode();

  /**
   * <code>string responseMessage = 4;</code>
   * @return The responseMessage.
   */
  java.lang.String getResponseMessage();
  /**
   * <code>string responseMessage = 4;</code>
   * @return The bytes for responseMessage.
   */
  com.google.protobuf.ByteString
      getResponseMessageBytes();
}
