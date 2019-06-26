package com.example.algamoney.api.service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.UUIDTimer;
import com.fasterxml.uuid.ext.FileBasedTimestampSynchronizer;

@Service
public class GeneratorUUID {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String criaUUID() {
		try {
			/* ESTE TRECHO DO CODIGO ME POSSIBILITA VER O IP E O MAC ADRRESS DA MAQUINA
			 * InetAddress ip; ip = InetAddress.getLocalHost(); logger.info("IP address : "
			 * + ip.getHostAddress()); NetworkInterface network =
			 * NetworkInterface.getByInetAddress(ip); byte[] mac =
			 * network.getHardwareAddress(); logger.info("MAC address : ");
			 * 
			 * StringBuilder sb = new StringBuilder(); for (int i = 0; i < mac.length; i++)
			 * { sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" :
			 * "")); } logger.info(sb.toString());
			 */
			EthernetAddress ethernetAddress = EthernetAddress.fromInterface();
			/* ESTE TRECHO DO CODIGO ERA UTILIZADO PARA FAZER O UUID, POREM O FileBasedTimestampSynchronizer SÓ É PERMITIDO SER UTILIZADO UMA VEZ
			UUIDTimer timer = new UUIDTimer(new Random(), new FileBasedTimestampSynchronizer());
			UUID uuid = Generators.timeBasedGenerator(nic, timer).generate();
			*/
			UUID uuid = Generators.timeBasedGenerator(ethernetAddress).generate();
			logger.info("UUID" + uuid);

			return uuid + "";
		} catch (Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
			return "erro";
		}

	}
}
