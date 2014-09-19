/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpdohp;

/**
 *
 * @author kimaniidaniel
 */
public class LatticePoint
{

    //private variables to hold the lattice information
    LatticePoint _left;
    LatticePoint _right;
    LatticePoint _bottom;
    LatticePoint _top;
    double _temperature;

    //constructor that sets the lattice information
    public LatticePoint(LatticePoint _left, LatticePoint _right, LatticePoint _bottom, LatticePoint _top, double _temperature)
    {
        this._left = _left;
        this._right = _right;
        this._bottom = _bottom;
        this._top = _top;
        this._temperature = _temperature;
    }

    public LatticePoint getBottom()
    {
        return _bottom;
    }

    public LatticePoint getLeft()
    {
        return _left;
    }

    public LatticePoint getRight()
    {
        return _right;
    }

    public double getTemperature()
    {
        return _temperature;
    }

    public LatticePoint getTop()
    {
        return _top;
    }
}
