package upt.magic.Model;

public class Usuario {
    private int ID;
    private String nombre;
    private String apellido_Paterno;
    private String apellido_Materno;
    private String correo;
    private String contrsenia;
    private String contrsenia2;
    private String fecha_Nacimiento;
    private String status;
    private String codigo_confirmacion;
    private String token_recovery;
    private String updateat;
    private String create_at;
    private String update_at;
    private String estatus;
    private String mensaje;

    public Usuario() {
    }

    public Usuario(int ID, String nombre, String apellido_Paterno, String apellido_Materno, String correo, String contrsenia, String contrsenia2, String fecha_Nacimiento, String status, String codigo_confirmacion, String token_recovery, String updateat, String create_at, String update_at, String estatus, String mensaje) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.correo = correo;
        this.contrsenia = contrsenia;
        this.contrsenia2 = contrsenia2;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.status = status;
        this.codigo_confirmacion = codigo_confirmacion;
        this.token_recovery = token_recovery;
        this.updateat = updateat;
        this.create_at = create_at;
        this.update_at = update_at;
        this.estatus = estatus;
        this.mensaje = mensaje;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrsenia() {
        return contrsenia;
    }

    public void setContrsenia(String contrsenia) {
        this.contrsenia = contrsenia;
    }

    public String getContrsenia2() {
        return contrsenia2;
    }

    public void setContrsenia2(String contrsenia2) {
        this.contrsenia2 = contrsenia2;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo_confirmacion() {
        return codigo_confirmacion;
    }

    public void setCodigo_confirmacion(String codigo_confirmacion) {
        this.codigo_confirmacion = codigo_confirmacion;
    }

    public String getToken_recovery() {
        return token_recovery;
    }

    public void setToken_recovery(String token_recovery) {
        this.token_recovery = token_recovery;
    }

    public String getUpdateat() {
        return updateat;
    }

    public void setUpdateat(String updateat) {
        this.updateat = updateat;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
