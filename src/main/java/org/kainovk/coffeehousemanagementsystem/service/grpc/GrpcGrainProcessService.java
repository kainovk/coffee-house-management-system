package org.kainovk.coffeehousemanagementsystem.service.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.kainovk.coffeehousemanagementsystem.service.GrainProcessService;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class GrpcGrainProcessService extends GrainProcessServiceGrpc.GrainProcessServiceImplBase {

    private final GrainProcessService grainProcessService;

    @Override
    public void process(GrainProcessRequest request, StreamObserver<GrainProcessResponse> responseObserver) {
        log.info("Received gRPC message: {}", request);

        grainProcessService.process(request);

        GrainProcessResponse response = GrainProcessResponse.newBuilder()
                .setMessage("Success!")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
