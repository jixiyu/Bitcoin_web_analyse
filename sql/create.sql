 create table txo(
	 tx_hash varchar(1000),
	 output_idx integer,
	 source varchar(1000),
	 destination varchar(1000),
	 value DECIMAL,
	 timestamp timestamp,
	 primary key(tx_hash, output_idx)
 );