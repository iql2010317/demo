package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {
	// String city �ݩʦW�٤p�g ����k�W�پm�p�j�g
	// �۩w�q��k �^�Ǧh�� �ϥ�List
	public List<PersonInfo> findByCity(String city);

	// �ӥB
	public List<PersonInfo> findByNameAndCity(String name, String city);

	// �Ϊ�
	public List<PersonInfo> findByNameOrCity(String name, String city);

	// 4.�~���j���J���󪺩Ҧ��ӤH��T
	public List<PersonInfo> findByAgeGreaterThan(int age);

	// 5.��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T �̦~�֥Ѥp��j�Ƨ�
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);

	// 6.���~�֤p���J����1�άO�j���J����2����T
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);

	// 7.���~������2�ӼƦr����(���]�t) ����T
	// �H�~�֥Ѥj��p�Ƨ�
	// �u���e3�����
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1, int age2);

	// 8.���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	public List<PersonInfo> findByCityContaining(String city);

	// 9.��X�~���j���J����H��city �]�t�Y�ӯS�w�r���Ҧ��H��T
	// �̷Ӧ~�֥Ѥj��p�Ƨ�
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int Age,String city);

}
