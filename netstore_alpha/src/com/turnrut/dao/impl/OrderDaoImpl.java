package com.turnrut.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.turnrut.dao.OrderDao;
import com.turnrut.dao.exception.DaoException;
import com.turnrut.domain.OderItem;
import com.turnrut.domain.Order;
import com.turnrut.utils.DbUtils;

public class OrderDaoImpl implements OrderDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
	@Override
	public void save(Order order) {
			if(order.getCustomer()==null){
				throw new IllegalArgumentException("用户不能为空，请登陆！");
			}
		try {
			qr.update("insert into orders(orderId,orderNum,quantity,amount,status,customerId) values (?,?,?,?,?,?)",
					order.getOrderId(),
					order.getOrderNum(),
					order.getQuantity(),
					order.getAmount(),
					order.getStatus(),
					order.getCustomer().getId());
			List<OderItem> list = order.getoItems();
			if(list.size()>0){
				for(OderItem item:list){
					qr.update("insert into orderitems(orderItemId,quantity,price,bookId,orderId) values (?,?,?,?,?)",
							item.getOrderItemId(),
							item.getQuantity(),
							item.getPrice(),
							item.getBook().getId(),
							order.getOrderId());
				}
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}

	@Override
	public void update(Order order) {
		try {
			qr.update("update orders set orderNum=?,quantity=?,amount=?,status=?,customerId=? where  orderId=?",
					order.getOrderNum(),
					order.getQuantity(),
					order.getAmount(),
					order.getStatus(),
					order.getCustomer().getId(),
					order.getOrderId()
					);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Order getById(String orderId) {
		try {
		return	qr.query("select * from orders where orderId=?",new BeanHandler<Order>(Order.class),orderId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Order> getByCusId(String cusId) {
		try {
			return	qr.query("select * from orders where customerId=?",new BeanListHandler<Order>(Order.class),cusId);
			} catch (Exception e) {
				throw new DaoException(e);
			}
	}

	@Override
	public Order getByNum(String num) {
		try {
			return	qr.query("select * from orders where orderNum=?",new BeanHandler<Order>(Order.class),num);
			} catch (Exception e) {
				throw new DaoException(e);
			}
	}

	@Override
	public void removeOder(String delOrderId) {
		try {
			qr.update("delete from orderitems where orderId =?",delOrderId);
			qr.update("delete from orders where orderId =?",delOrderId);
			} catch (Exception e) {
				throw new DaoException(e);
			}
	}

}
