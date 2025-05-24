package controller;

import model.*;
import java.util.List;
import java.util.Optional;

public class MotorController {
    private motorDAO dao = new motorDAO();

    public void agregarMotor(Motor motor) {
        dao.agregarMotor(motor);
    }

    public List<Motor> listarMotores() {
        return dao.listarTodosLosMotores();
    }

    public Optional<Motor> buscarMotor(String numeroMotor) {
        return dao.buscarMotorPorNumero(numeroMotor);
    }

    public void actualizarMotor(Motor motor) {
        dao.actualizarMotor(motor);
    }

    public void eliminarMotor(String numeroMotor) {
        dao.eliminarMotor(numeroMotor);
    }
} 