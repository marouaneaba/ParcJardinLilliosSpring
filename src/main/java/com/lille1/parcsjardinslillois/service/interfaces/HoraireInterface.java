package com.lille1.parcsjardinslillois.service.interfaces;


@FunctionalInterface
public interface HoraireInterface {

	public void modifierHorairePJ(Long idH, String journee, String ouverture, String fermeture);

}
