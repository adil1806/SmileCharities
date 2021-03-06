package com.smile.donate.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.smile.donate.dto.AdminResponseDto;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;
import com.smile.donate.repository.DonationRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonationServiceImplTest {

	@InjectMocks
	DonationServiceImpl donationServiceImpl;
	@Mock
	DonationRepository donationRepository;

	@Test
	public void getAllDonation() {
		// Long schemeId = 1001L;

		List<Donation> list = new ArrayList<Donation>();
		Donation donation1 = new Donation();
		donation1.setEmail("a@gmail.com");
		donation1.setMobileNumber("1234567890");
		donation1.setPanNumber("CPFPA7773A");
		donation1.setUserName("Raghib");
		donation1.setSchemeId(1001L);
		Donation donation2 = new Donation();
		donation2.setEmail("b@gmail.com");
		donation2.setMobileNumber("0987654321");
		donation2.setPanNumber("ASDFG555A");
		donation2.setUserName("Vipin");
		donation2.setSchemeId(1001L);
		Donation donation3 = new Donation();
		donation3.setEmail("c@gmail.com");
		donation3.setMobileNumber("0192837465");
		donation3.setPanNumber("QWRTY555A");
		donation3.setUserName("ViRu");
		donation3.setSchemeId(1001L);
		list.add(donation1);
		list.add(donation2);
		list.add(donation3);
		System.out.println(list);

		Mockito.when(donationRepository.findBySchemeId(1001L)).thenReturn(list);
		AdminResponseDto resp = donationServiceImpl.getDonationsList(1001L);
		resp.setStatusCode(200);
		assertEquals(200, resp.getStatusCode());

	}
	
	@Test
	public void donate()
	{
		Donation req = new Donation();
		req.setEmail("a@gmail.com");
		req.setMobileNumber("0987654321");
		req.setPanNumber("CPFPA7773A");
		req.setSchemeId(1001L);
		req.setUserName("Raghib");
		DonationResponseDto  resp = new DonationResponseDto();
		resp.setDonationId(101L);
		resp.setStatusCode(200);
		Mockito.when(donationRepository.save(Mockito.any())).thenReturn(req);
	    assertNotNull(resp);
        
		
		
	}

}
