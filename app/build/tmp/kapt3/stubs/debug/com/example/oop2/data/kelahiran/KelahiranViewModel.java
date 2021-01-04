package com.example.oop2.data.kelahiran;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/oop2/data/kelahiran/KelahiranViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "aplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "readAllkelahiran", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/oop2/data/kelahiran/Kelahiran;", "getReadAllkelahiran", "()Landroidx/lifecycle/LiveData;", "setReadAllkelahiran", "(Landroidx/lifecycle/LiveData;)V", "repository", "Lcom/example/oop2/data/kelahiran/KelahiranRepository;", "addKelahiran", "", "kelahiran", "deleteAllKelahiran", "deleteKelahiran", "updateKelahiran", "app_debug"})
public final class KelahiranViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.example.oop2.data.kelahiran.Kelahiran>> readAllkelahiran;
    private final com.example.oop2.data.kelahiran.KelahiranRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.oop2.data.kelahiran.Kelahiran>> getReadAllkelahiran() {
        return null;
    }
    
    public final void setReadAllkelahiran(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.example.oop2.data.kelahiran.Kelahiran>> p0) {
    }
    
    public final void addKelahiran(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.kelahiran.Kelahiran kelahiran) {
    }
    
    public final void updateKelahiran(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.kelahiran.Kelahiran kelahiran) {
    }
    
    public final void deleteKelahiran(@org.jetbrains.annotations.NotNull()
    com.example.oop2.data.kelahiran.Kelahiran kelahiran) {
    }
    
    public final void deleteAllKelahiran() {
    }
    
    public KelahiranViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application aplication) {
        super(null);
    }
}