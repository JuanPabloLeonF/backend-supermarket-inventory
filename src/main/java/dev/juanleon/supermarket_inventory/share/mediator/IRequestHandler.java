package dev.juanleon.supermarket_inventory.share.mediator;

public interface IRequestHandler<T extends IRequest<R>, R> {
    public R handle(T request);
    public Class<T> getRequestType();
}
