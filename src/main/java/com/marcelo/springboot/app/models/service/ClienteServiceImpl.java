package com.marcelo.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.springboot.app.models.dao.IClienteDao;
import com.marcelo.springboot.app.models.dao.IFacturaDao;
import com.marcelo.springboot.app.models.dao.IProductoDao;
import com.marcelo.springboot.app.models.entity.Cliente;
import com.marcelo.springboot.app.models.entity.Factura;
import com.marcelo.springboot.app.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private IFacturaDao facturaDao;

	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findOne(Long id) {
		return clienteDao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);	
	}

	@Override
	@Transactional
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional
	public Optional<Producto> findProductoById(Long id) {
		return productoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> findById(Long id) {
		return facturaDao.findById(id);
	}
}
