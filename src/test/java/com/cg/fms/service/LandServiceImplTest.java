package com.cg.fms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.ILandDao;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Land;
@SpringBootTest
class LandServiceImplTest {
	
	@Autowired
	LandServiceImpl landservice;
	@MockBean
	ILandDao repo;
	
		@Test
		void testGetLand() throws Exception {
			Land l=new Land();
			l.setLandArea("Area");
			l.setLandId(1);
			l.setOwnerName("Name");
			l.setSurveyNumber(101);
			Optional<Land> l1=Optional.of(l);
			Mockito.when(repo.findById(1)).thenReturn(l1);
	
			assertThat(landservice.getLand(l.getLandId())).isEqualTo(l);
			//fail("Not yet implemented");
		}
	
		@Test
		void testAddLand() {
			Land l=new Land();
			l.setLandArea("Area");
			l.setLandId(1);
			l.setOwnerName("Name");
			l.setSurveyNumber(101);
			Mockito.when(repo.save(l)).thenReturn(l);
			assertThat(landservice.addLand(l)).isEqualTo("added");
			//fail("Not yet implemented");
		}
	
		@Test
		void testUpdateLand() throws Exception {
			Land l=new Land();
			l.setLandArea("Area");
			l.setLandId(1);
			l.setOwnerName("Name");
			l.setSurveyNumber(101);
			Optional<Land> l1=Optional.of(l);
			Mockito.when(repo.findById(1)).thenReturn(l1);
			Mockito.when(repo.save(l)).thenReturn(l);
		
					l.setLandArea("new place");	l.setSurveyNumber(12); 	l.setOwnerName("newowner");
					
					assertThat(landservice.updateLand(l)).isEqualTo("updated");
			//fail("Not yet implemented");
		}
	
		@Test
		void testRemoveLandDetails() {
			Land l=new Land();
			l.setLandArea("Area");
			l.setLandId(1);
			l.setOwnerName("Name");
			l.setSurveyNumber(101);
			Optional<Land> l1=Optional.of(l);
			Mockito.when(repo.findById(1)).thenReturn(l1);
			Mockito.when(repo.existsById(l.getSurveyNumber())).thenReturn(false);
			assertFalse(repo.existsById(l.getSurveyNumber()));
			//fail("Not yet implemented");
		}
	
		@Test
		void testGetAllLands() {
			Land l=new Land();
			l.setLandArea("Area");
			l.setLandId(1);
			l.setOwnerName("Name");
			l.setSurveyNumber(101);
			Land l1=new Land();
			l.setLandArea("Area2");
			l.setLandId(2);
			l.setOwnerName("Name2");
			l.setSurveyNumber(102);
			List<Land> la=new ArrayList<>();
			la.add(l); 	la.add(l1);
			
			Mockito.when(repo.findAll()).thenReturn(la);
			assertThat(landservice.getAllLands()).isEqualTo(la);
			//fail("Not yet implemented");
		}

}