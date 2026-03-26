package dev.juanleon.supermarket_inventory.common.mediator;

public interface IRequestHandler<T extends IRequest<R>, R> {
    public R handle(T request);
    public Class<T> getRequestType();
}
