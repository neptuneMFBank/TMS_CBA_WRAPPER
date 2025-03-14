// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: debitcredit.proto

package com.neptune.cba.transaction.debit_credit;

public final class Debitcredit {
  private Debitcredit() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_neptune_cba_DebitCreditStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_neptune_cba_DebitCreditStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_neptune_cba_DebitCreditStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_neptune_cba_DebitCreditStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_neptune_cba_DebitCreditRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_neptune_cba_DebitCreditRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_neptune_cba_Charge_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_neptune_cba_Charge_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_neptune_cba_DebitCreditResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_neptune_cba_DebitCreditResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021debitcredit.proto\022\017com.neptune.cba\"2\n\030" +
      "DebitCreditStatusRequest\022\026\n\016transactionR" +
      "ef\030\001 \001(\t\";\n\031DebitCreditStatusResponse\022\020\n" +
      "\010response\030\001 \001(\t\022\014\n\004code\030\002 \001(\t\"\214\002\n\022DebitC" +
      "reditRequest\022\025\n\raccountnumber\030\001 \001(\t\022\017\n\007i" +
      "sccode\030\002 \001(\t\022\025\n\raccountstatus\030\003 \001(\t\022\020\n\010a" +
      "cctname\030\004 \001(\t\022\014\n\004drcr\030\005 \001(\t\022\017\n\007acctype\030\006" +
      " \001(\t\022\016\n\006amount\030\007 \001(\001\022\034\n\024transactionrefer" +
      "ence\030\010 \001(\t\022\021\n\tnarration\030\t \001(\t\022\017\n\007channel" +
      "\030\n \001(\t\022\013\n\003eid\030\013 \001(\t\022\'\n\006charge\030\014 \003(\0132\027.co" +
      "m.neptune.cba.Charge\"=\n\006Charge\022\016\n\006amount" +
      "\030\001 \001(\001\022\023\n\013description\030\002 \001(\t\022\016\n\006ledger\030\003 " +
      "\001(\t\"4\n\023DebitCreditResponse\022\017\n\007message\030\001 " +
      "\001(\t\022\014\n\004code\030\002 \001(\t2\341\001\n\022DebitCreditService" +
      "\022[\n\014debit_credit\022#.com.neptune.cba.Debit" +
      "CreditRequest\032$.com.neptune.cba.DebitCre" +
      "ditResponse\"\000\022n\n\023debit_credit_status\022).c" +
      "om.neptune.cba.DebitCreditStatusRequest\032" +
      "*.com.neptune.cba.DebitCreditStatusRespo" +
      "nse\"\000B,\n(com.neptune.cba.transaction.deb" +
      "it_creditP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_neptune_cba_DebitCreditStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_neptune_cba_DebitCreditStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_neptune_cba_DebitCreditStatusRequest_descriptor,
        new java.lang.String[] { "TransactionRef", });
    internal_static_com_neptune_cba_DebitCreditStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_neptune_cba_DebitCreditStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_neptune_cba_DebitCreditStatusResponse_descriptor,
        new java.lang.String[] { "Response", "Code", });
    internal_static_com_neptune_cba_DebitCreditRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_neptune_cba_DebitCreditRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_neptune_cba_DebitCreditRequest_descriptor,
        new java.lang.String[] { "Accountnumber", "Isccode", "Accountstatus", "Acctname", "Drcr", "Acctype", "Amount", "Transactionreference", "Narration", "Channel", "Eid", "Charge", });
    internal_static_com_neptune_cba_Charge_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_neptune_cba_Charge_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_neptune_cba_Charge_descriptor,
        new java.lang.String[] { "Amount", "Description", "Ledger", });
    internal_static_com_neptune_cba_DebitCreditResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_neptune_cba_DebitCreditResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_neptune_cba_DebitCreditResponse_descriptor,
        new java.lang.String[] { "Message", "Code", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
