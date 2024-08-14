package com.clpa_partners.gestion_bibliotheque_clap_partner.dao;

public interface BookAdapterFactory {
	  public <T> BookAdapterService<T> getService(String serviceName);
	}
