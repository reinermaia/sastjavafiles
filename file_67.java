    @Override
    public ChannelFuture goAway(ChannelHandlerContext ctx, int lastStreamId, long errorCode, ByteBuf debugData,
                                ChannelPromise promise) {
        if (!ctx.channel().isActive()) {
            // There's no point of sending a GOAWAY frame because the connection is over already.
            promise.unvoid().trySuccess();
            debugData.release();
            return promise;
        }

        return super.goAway(ctx, lastStreamId, errorCode, debugData, promise);
    }