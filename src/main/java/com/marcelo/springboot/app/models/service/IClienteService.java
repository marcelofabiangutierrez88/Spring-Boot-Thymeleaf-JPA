package com.marcelo.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marcelo.springboot.app.models.entity.Cliente;
import com.marcelo.springboot.app.models.entity.Factura;
import com.marcelo.springboot.app.models.entity.Producto;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public Page<Cliente> findAll(Pageable pageable);
	public void save(Cliente cliente);
	public Optional<Cliente> findOne(Long id);
	public void delete(Long id);
	public List<Producto> findByNombre(String term);
	public void saveFactura (Factura factura);
	public Optional<Producto> findProductoById(Long id);
	public Optional<Factura> findById (Long id);

}
