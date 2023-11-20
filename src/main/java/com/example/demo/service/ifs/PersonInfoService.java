package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {

	public void addInfo(PersonInfo personInfo);

	void addInfoList(List<PersonInfo> infoList);


	// 2. ���o�Ҧ��ӤH��T
	void findAllIdList(List<PersonInfo> infoList);

	// 3.�z�L id ���o�������ӤH��T
	void findByIdInfo(PersonInfo personInfo);

	// 4.�~���j���J���󪺩Ҧ��ӤH��T
	void findAgeList(List<PersonInfo> infoList);

	// 5.��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T �̦~�֥Ѥp��j�Ƨ�
	void findAgeLessThanEqualList(List<PersonInfo> infoList);

	// 6.���~�֤p���J����1�άO�j���J����2����T
	void findAgeBigSmallList(List<PersonInfo> infoList);

	// 7.���~������2�ӼƦr����(���]�t) ����T
	// �H�~�֥Ѥj��p�Ƨ�
	// �u���e3�����
	void findSevenList(List<PersonInfo> infoList);

	// 8.���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	void find8List(List<PersonInfo> infoList);

	// 9.��X�~���j���J����H��city �]�t�Y�ӯS�w�r���Ҧ��H��T
	// �̷Ӧ~�֥Ѥj��p�Ƨ�
	void find9List(List<PersonInfo> infoList);

}
