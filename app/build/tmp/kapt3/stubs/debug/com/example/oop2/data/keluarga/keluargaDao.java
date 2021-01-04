package com.example.oop2.data.keluarga;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/oop2/data/keluarga/keluargaDao;", "", "addKeluarga", "", "keluarga", "Lcom/example/oop2/data/keluarga/Keluarga;", "(Lcom/example/oop2/data/keluarga/Keluarga;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllKeluarga", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteKeluarga", "readAllKeluarga", "Landroidx/lifecycle/LiveData;", "", "updateKeluarga", "app_debug"})
public abstract interface keluargaDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object addKeluarga(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.keluarga.Keluarga keluarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM data_keluarga ORDER BY id ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.oop2.data.keluarga.Keluarga>> readAllKeluarga();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateKeluarga(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.keluarga.Keluarga keluarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM data_keluarga")
    public abstract java.lang.Object deleteAllKeluarga(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteKeluarga(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.keluarga.Keluarga keluarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}