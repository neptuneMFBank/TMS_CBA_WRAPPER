package printable;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: printable.proto")
public final class PrintableGrpc {

  private PrintableGrpc() {}

  public static final String SERVICE_NAME = "printable.Printable";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetTrialBalanceRequest,
      printable.PrintableOuterClass.PDFResponse> getGetTrialBalancePdfMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrialBalancePdf",
      requestType = printable.PrintableOuterClass.GetTrialBalanceRequest.class,
      responseType = printable.PrintableOuterClass.PDFResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetTrialBalanceRequest,
      printable.PrintableOuterClass.PDFResponse> getGetTrialBalancePdfMethod() {
    io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetTrialBalanceRequest, printable.PrintableOuterClass.PDFResponse> getGetTrialBalancePdfMethod;
    if ((getGetTrialBalancePdfMethod = PrintableGrpc.getGetTrialBalancePdfMethod) == null) {
      synchronized (PrintableGrpc.class) {
        if ((getGetTrialBalancePdfMethod = PrintableGrpc.getGetTrialBalancePdfMethod) == null) {
          PrintableGrpc.getGetTrialBalancePdfMethod = getGetTrialBalancePdfMethod =
              io.grpc.MethodDescriptor.<printable.PrintableOuterClass.GetTrialBalanceRequest, printable.PrintableOuterClass.PDFResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrialBalancePdf"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.GetTrialBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.PDFResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrintableMethodDescriptorSupplier("GetTrialBalancePdf"))
              .build();
        }
      }
    }
    return getGetTrialBalancePdfMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printable.PrintableOuterClass.LoanReportsRequest,
      printable.PrintableOuterClass.PDFResponse> getLoanReportPdfMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoanReportPdf",
      requestType = printable.PrintableOuterClass.LoanReportsRequest.class,
      responseType = printable.PrintableOuterClass.PDFResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printable.PrintableOuterClass.LoanReportsRequest,
      printable.PrintableOuterClass.PDFResponse> getLoanReportPdfMethod() {
    io.grpc.MethodDescriptor<printable.PrintableOuterClass.LoanReportsRequest, printable.PrintableOuterClass.PDFResponse> getLoanReportPdfMethod;
    if ((getLoanReportPdfMethod = PrintableGrpc.getLoanReportPdfMethod) == null) {
      synchronized (PrintableGrpc.class) {
        if ((getLoanReportPdfMethod = PrintableGrpc.getLoanReportPdfMethod) == null) {
          PrintableGrpc.getLoanReportPdfMethod = getLoanReportPdfMethod =
              io.grpc.MethodDescriptor.<printable.PrintableOuterClass.LoanReportsRequest, printable.PrintableOuterClass.PDFResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoanReportPdf"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.LoanReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.PDFResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrintableMethodDescriptorSupplier("LoanReportPdf"))
              .build();
        }
      }
    }
    return getLoanReportPdfMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetBillingMemoRequest,
      printable.PrintableOuterClass.PDFResponse> getBillMemoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BillMemo",
      requestType = printable.PrintableOuterClass.GetBillingMemoRequest.class,
      responseType = printable.PrintableOuterClass.PDFResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetBillingMemoRequest,
      printable.PrintableOuterClass.PDFResponse> getBillMemoMethod() {
    io.grpc.MethodDescriptor<printable.PrintableOuterClass.GetBillingMemoRequest, printable.PrintableOuterClass.PDFResponse> getBillMemoMethod;
    if ((getBillMemoMethod = PrintableGrpc.getBillMemoMethod) == null) {
      synchronized (PrintableGrpc.class) {
        if ((getBillMemoMethod = PrintableGrpc.getBillMemoMethod) == null) {
          PrintableGrpc.getBillMemoMethod = getBillMemoMethod =
              io.grpc.MethodDescriptor.<printable.PrintableOuterClass.GetBillingMemoRequest, printable.PrintableOuterClass.PDFResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BillMemo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.GetBillingMemoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.PDFResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrintableMethodDescriptorSupplier("BillMemo"))
              .build();
        }
      }
    }
    return getBillMemoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printable.PrintableOuterClass.StatementRequest,
      printable.PrintableOuterClass.StatementOfAccountResponse> getStatementOfAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StatementOfAccount",
      requestType = printable.PrintableOuterClass.StatementRequest.class,
      responseType = printable.PrintableOuterClass.StatementOfAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printable.PrintableOuterClass.StatementRequest,
      printable.PrintableOuterClass.StatementOfAccountResponse> getStatementOfAccountMethod() {
    io.grpc.MethodDescriptor<printable.PrintableOuterClass.StatementRequest, printable.PrintableOuterClass.StatementOfAccountResponse> getStatementOfAccountMethod;
    if ((getStatementOfAccountMethod = PrintableGrpc.getStatementOfAccountMethod) == null) {
      synchronized (PrintableGrpc.class) {
        if ((getStatementOfAccountMethod = PrintableGrpc.getStatementOfAccountMethod) == null) {
          PrintableGrpc.getStatementOfAccountMethod = getStatementOfAccountMethod =
              io.grpc.MethodDescriptor.<printable.PrintableOuterClass.StatementRequest, printable.PrintableOuterClass.StatementOfAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StatementOfAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.StatementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.StatementOfAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrintableMethodDescriptorSupplier("StatementOfAccount"))
              .build();
        }
      }
    }
    return getStatementOfAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printable.PrintableOuterClass.PdfRequest,
      printable.PrintableOuterClass.PdfResponse> getFileToPdfMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FileToPdf",
      requestType = printable.PrintableOuterClass.PdfRequest.class,
      responseType = printable.PrintableOuterClass.PdfResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printable.PrintableOuterClass.PdfRequest,
      printable.PrintableOuterClass.PdfResponse> getFileToPdfMethod() {
    io.grpc.MethodDescriptor<printable.PrintableOuterClass.PdfRequest, printable.PrintableOuterClass.PdfResponse> getFileToPdfMethod;
    if ((getFileToPdfMethod = PrintableGrpc.getFileToPdfMethod) == null) {
      synchronized (PrintableGrpc.class) {
        if ((getFileToPdfMethod = PrintableGrpc.getFileToPdfMethod) == null) {
          PrintableGrpc.getFileToPdfMethod = getFileToPdfMethod =
              io.grpc.MethodDescriptor.<printable.PrintableOuterClass.PdfRequest, printable.PrintableOuterClass.PdfResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FileToPdf"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.PdfRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printable.PrintableOuterClass.PdfResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrintableMethodDescriptorSupplier("FileToPdf"))
              .build();
        }
      }
    }
    return getFileToPdfMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrintableStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintableStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintableStub>() {
        @java.lang.Override
        public PrintableStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintableStub(channel, callOptions);
        }
      };
    return PrintableStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrintableBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintableBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintableBlockingStub>() {
        @java.lang.Override
        public PrintableBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintableBlockingStub(channel, callOptions);
        }
      };
    return PrintableBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrintableFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintableFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintableFutureStub>() {
        @java.lang.Override
        public PrintableFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintableFutureStub(channel, callOptions);
        }
      };
    return PrintableFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrintableImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTrialBalancePdf(printable.PrintableOuterClass.GetTrialBalanceRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrialBalancePdfMethod(), responseObserver);
    }

    /**
     */
    public void loanReportPdf(printable.PrintableOuterClass.LoanReportsRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoanReportPdfMethod(), responseObserver);
    }

    /**
     */
    public void billMemo(printable.PrintableOuterClass.GetBillingMemoRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBillMemoMethod(), responseObserver);
    }

    /**
     */
    public void statementOfAccount(printable.PrintableOuterClass.StatementRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.StatementOfAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStatementOfAccountMethod(), responseObserver);
    }

    /**
     */
    public void fileToPdf(printable.PrintableOuterClass.PdfRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PdfResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFileToPdfMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTrialBalancePdfMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                printable.PrintableOuterClass.GetTrialBalanceRequest,
                printable.PrintableOuterClass.PDFResponse>(
                  this, METHODID_GET_TRIAL_BALANCE_PDF)))
          .addMethod(
            getLoanReportPdfMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                printable.PrintableOuterClass.LoanReportsRequest,
                printable.PrintableOuterClass.PDFResponse>(
                  this, METHODID_LOAN_REPORT_PDF)))
          .addMethod(
            getBillMemoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                printable.PrintableOuterClass.GetBillingMemoRequest,
                printable.PrintableOuterClass.PDFResponse>(
                  this, METHODID_BILL_MEMO)))
          .addMethod(
            getStatementOfAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                printable.PrintableOuterClass.StatementRequest,
                printable.PrintableOuterClass.StatementOfAccountResponse>(
                  this, METHODID_STATEMENT_OF_ACCOUNT)))
          .addMethod(
            getFileToPdfMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                printable.PrintableOuterClass.PdfRequest,
                printable.PrintableOuterClass.PdfResponse>(
                  this, METHODID_FILE_TO_PDF)))
          .build();
    }
  }

  /**
   */
  public static final class PrintableStub extends io.grpc.stub.AbstractAsyncStub<PrintableStub> {
    private PrintableStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintableStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintableStub(channel, callOptions);
    }

    /**
     */
    public void getTrialBalancePdf(printable.PrintableOuterClass.GetTrialBalanceRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrialBalancePdfMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loanReportPdf(printable.PrintableOuterClass.LoanReportsRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoanReportPdfMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void billMemo(printable.PrintableOuterClass.GetBillingMemoRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBillMemoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void statementOfAccount(printable.PrintableOuterClass.StatementRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.StatementOfAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStatementOfAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fileToPdf(printable.PrintableOuterClass.PdfRequest request,
        io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PdfResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFileToPdfMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrintableBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrintableBlockingStub> {
    private PrintableBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintableBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintableBlockingStub(channel, callOptions);
    }

    /**
     */
    public printable.PrintableOuterClass.PDFResponse getTrialBalancePdf(printable.PrintableOuterClass.GetTrialBalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrialBalancePdfMethod(), getCallOptions(), request);
    }

    /**
     */
    public printable.PrintableOuterClass.PDFResponse loanReportPdf(printable.PrintableOuterClass.LoanReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoanReportPdfMethod(), getCallOptions(), request);
    }

    /**
     */
    public printable.PrintableOuterClass.PDFResponse billMemo(printable.PrintableOuterClass.GetBillingMemoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBillMemoMethod(), getCallOptions(), request);
    }

    /**
     */
    public printable.PrintableOuterClass.StatementOfAccountResponse statementOfAccount(printable.PrintableOuterClass.StatementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStatementOfAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public printable.PrintableOuterClass.PdfResponse fileToPdf(printable.PrintableOuterClass.PdfRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFileToPdfMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrintableFutureStub extends io.grpc.stub.AbstractFutureStub<PrintableFutureStub> {
    private PrintableFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintableFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintableFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printable.PrintableOuterClass.PDFResponse> getTrialBalancePdf(
        printable.PrintableOuterClass.GetTrialBalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrialBalancePdfMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printable.PrintableOuterClass.PDFResponse> loanReportPdf(
        printable.PrintableOuterClass.LoanReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoanReportPdfMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printable.PrintableOuterClass.PDFResponse> billMemo(
        printable.PrintableOuterClass.GetBillingMemoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBillMemoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printable.PrintableOuterClass.StatementOfAccountResponse> statementOfAccount(
        printable.PrintableOuterClass.StatementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStatementOfAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printable.PrintableOuterClass.PdfResponse> fileToPdf(
        printable.PrintableOuterClass.PdfRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFileToPdfMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRIAL_BALANCE_PDF = 0;
  private static final int METHODID_LOAN_REPORT_PDF = 1;
  private static final int METHODID_BILL_MEMO = 2;
  private static final int METHODID_STATEMENT_OF_ACCOUNT = 3;
  private static final int METHODID_FILE_TO_PDF = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrintableImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrintableImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRIAL_BALANCE_PDF:
          serviceImpl.getTrialBalancePdf((printable.PrintableOuterClass.GetTrialBalanceRequest) request,
              (io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse>) responseObserver);
          break;
        case METHODID_LOAN_REPORT_PDF:
          serviceImpl.loanReportPdf((printable.PrintableOuterClass.LoanReportsRequest) request,
              (io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse>) responseObserver);
          break;
        case METHODID_BILL_MEMO:
          serviceImpl.billMemo((printable.PrintableOuterClass.GetBillingMemoRequest) request,
              (io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PDFResponse>) responseObserver);
          break;
        case METHODID_STATEMENT_OF_ACCOUNT:
          serviceImpl.statementOfAccount((printable.PrintableOuterClass.StatementRequest) request,
              (io.grpc.stub.StreamObserver<printable.PrintableOuterClass.StatementOfAccountResponse>) responseObserver);
          break;
        case METHODID_FILE_TO_PDF:
          serviceImpl.fileToPdf((printable.PrintableOuterClass.PdfRequest) request,
              (io.grpc.stub.StreamObserver<printable.PrintableOuterClass.PdfResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrintableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrintableBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return printable.PrintableOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Printable");
    }
  }

  private static final class PrintableFileDescriptorSupplier
      extends PrintableBaseDescriptorSupplier {
    PrintableFileDescriptorSupplier() {}
  }

  private static final class PrintableMethodDescriptorSupplier
      extends PrintableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrintableMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrintableGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrintableFileDescriptorSupplier())
              .addMethod(getGetTrialBalancePdfMethod())
              .addMethod(getLoanReportPdfMethod())
              .addMethod(getBillMemoMethod())
              .addMethod(getStatementOfAccountMethod())
              .addMethod(getFileToPdfMethod())
              .build();
        }
      }
    }
    return result;
  }
}
