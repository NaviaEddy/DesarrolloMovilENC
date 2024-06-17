package com.example.segundoparcial_sis104.Backend

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class WSPuntos {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("x1")
    @Expose
    private var x1: Float? = null

    @SerializedName("y1")
    @Expose
    private var y1: Float? = null

    @SerializedName("x2")
    @Expose
    private var x2: Float? = null

    @SerializedName("y2")
    @Expose
    private var y2: Float? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getX1(): Float? {
        return x1
    }

    fun setX1(x1: Float?) {
        this.x1 = x1
    }

    fun getY1(): Float? {
        return y1
    }

    fun setY1(y1: Float?) {
        this.y1 = y1
    }

    fun getX2(): Float? {
        return x2
    }

    fun setX2(x2: Float?) {
        this.x2 = x2
    }

    fun getY2(): Float? {
        return y2
    }

    fun setY2(y2: Float?) {
        this.y2 = y2
    }
}