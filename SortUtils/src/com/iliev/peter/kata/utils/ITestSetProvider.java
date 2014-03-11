package com.iliev.peter.kata.utils;

import java.rmi.RemoteException;

import com.iliev.peter.kata.conventions.ISortTestSet;

public interface ITestSetProvider {
	ISortTestSet[] getAll() throws RemoteException;
}