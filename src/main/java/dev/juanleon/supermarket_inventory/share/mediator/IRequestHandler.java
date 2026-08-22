package dev.juanleon.supermarket_inventory.share.mediator;

public interface IRequestHandler<T extends IRequest<R>, R> {
    R handle(T request);
    Class<T> getRequestType();
}
