create table clientes (nombre varchar (200) not null, apellido varchar (200) not null,
                       dni int not null, id_cliente int not null, primary key (id_cliente));

create table productos (codigo int not null, descripcion varchar (700) not null, 
                        precio float not null, stock_disponible int not null, 
                        primary key (codigo));

create table Venta_Comprobante ( id_comprobante int not null, id_cliente int not null, 
			                     nombre_completo varchar(100) not null, fecha varchar(10) not null,
								 total float not null,
                                 primary key (id_comprobante),
                                constraint fk_cliente foreign key (id_cliente)
                                references clientes (id_cliente)
                                );
                                
create table Linea_De_Venta (id_venta int not null, codigo int not null,
							descripcion varchar(700), precio float not null,
							cantidad int not null, id_comprobante int not null,
                                      primary key (id_venta),
                                      constraint fk_producto foreign key (codigo)
                                      references productos (codigo),
                                      constraint fk_comprobante foreign key (id_comprobante)
                                      references comprobante_venta (id_comprobante)
                                      );
                       