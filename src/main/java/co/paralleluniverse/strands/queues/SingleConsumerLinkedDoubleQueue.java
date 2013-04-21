/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.paralleluniverse.strands.queues;

/**
 *
 * @author pron
 */
public class SingleConsumerLinkedDoubleQueue extends SingleConsumerLinkedDWordQueue<Double> implements SingleConsumerDoubleQueue<SingleConsumerLinkedQueue.Node<Double>> {
    @Override
    public boolean enq(double item) {
        return super.enq(Double.doubleToRawLongBits(item));
    }

    @Override
    public boolean enq(Double item) {
        if (item == null)
            throw new IllegalArgumentException("null values not allowed");
        return enq(item.doubleValue());
    }

    @Override
    public double doubleValue(Node<Double> node) {
        return Double.longBitsToDouble(rawValue(node));
    }

    @Override
    public Double value(Node<Double> node) {
        return doubleValue(node);
    }
}
