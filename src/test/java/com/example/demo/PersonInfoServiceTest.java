package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest
public class PersonInfoServiceTest {

	@Autowired
	private PersonInfoService addInfoService;

	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void addInfoServie() {
		addInfoService.addInfo(new PersonInfo("Z123356766", "zack", 35, "tainan"));
	}
	
	//1. �Ыظ�T
	//�i�Ы� 1~ �h����T(�b���έ^��r���}�Y�Y�i)
	//�u��s�W�s��T
	//�^�ǳQ�Ыت���T�B�T��
	@Test //�Ȯɤ�ʷs�W �γo��
	public void addInfoServie2() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A180032776", "ROBINSON",15, "Miaoli"));
		list.add(new PersonInfo("E152983968", "WILCOX", 20, "Taizhong"));
		list.add(new PersonInfo("J222989921", "KEITH", 23, "Jiayi"));
		list.add(new PersonInfo("R241567325", "OSBORN", 24, "Taizhong"));
		list.add(new PersonInfo("O171584733", "EATON", 28, "Jiayi"));
		list.add(new PersonInfo("I271255925", "STOKES", 30, "Tainan"));
		list.add(new PersonInfo("H111246190", "HOUSTON", 32, "Taipei"));
		list.add(new PersonInfo("H208420344", "LANG", 34, "Tainan"));
		list.add(new PersonInfo("G274308641", "RAY", 40, "Taipei"));
		list.add(new PersonInfo("K125154045", "AYALA", 45, "Tainan"));
		addInfoService.addInfoList(list);
	}

	@Test //�o�Ӥ���
	public void daoSaveAllTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456789", "ddd", 28, "ttt"));
		list.add(new PersonInfo("C163456780", "ddd", 28, "ttt"));
		list.add(new PersonInfo("H123486486", "haha", 28, "rrr"));
		personInfoDao.saveAll(list);
	}

	@Test
	public void daoFindTest() {
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456789");
//		;
		if (infoOp.isEmpty()) {
			System.out.println("�S��즹ID");
			return;
		}
		System.out.println((infoOp.get().getName()));
	}

	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for (PersonInfo item : list) {
			System.out.println(item.getName());
		}
	}

	@Test
	public void daoFindTest3() {
		boolean result = personInfoDao.existsById("A123456789");
		System.out.println(result);
		// �Ҧp�F��Email��pk �A���U�e�A�ݭn�P�_Email�O�_�s�b
		// save��\�e�A�u�s�b�bJpa�̭���save �קK��\�e�A�h�ݭn���P�_Exist;
	}

	@Test
	public void daoFindTest4() {
		List<PersonInfo> result = personInfoDao.findByCity("chayi");
		for (PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}

	@Test
	//2. ���o�Ҧ��ӤH��T
	public void findAllIdTest() {
		addInfoService.findAllIdList(new ArrayList<>());
	}
	
	@Test
	//3.�z�L id ���o�������ӤH��T
	public void findByIdTest() {
		addInfoService.findByIdInfo(new PersonInfo());
	}
	
	@Test // 4.�~���j���J���󪺩Ҧ��ӤH��T
	public void compareTest() {
		addInfoService.findAgeList(new ArrayList<>());
	}

	@Test // 5.��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T �̦~�֥Ѥp��j�Ƨ�
	public void LessThanEqualTest() {
		addInfoService.findAgeLessThanEqualList(new ArrayList<>());
	}

	@Test // 6.���~�֤p���J����1�άO�j���J����2����T
	public void bigSmallTest() {
		addInfoService.findAgeBigSmallList(new ArrayList<>());
	}

	@Test
	//// 7.���~������2�ӼƦr����(���]�t) ����T
	// �H�~�֥Ѥj��p�Ƨ�
	// �u���e3�����
	public void betweenTest() {
		addInfoService.findSevenList(new ArrayList<>());
	}

	@Test
	// 8.���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	public void cityContainingTest() {
		addInfoService.find8List(new ArrayList<>());
	}

	@Test
	// 9.��X�~���j���J����H��city �]�t�Y�ӯS�w�r���Ҧ��H��T
	// �̷Ӧ~�֥Ѥj��p�Ƨ�
	public void ageAndCityTest() {
		addInfoService.find9List(new ArrayList<>());
	}
	

	

	
	

}
