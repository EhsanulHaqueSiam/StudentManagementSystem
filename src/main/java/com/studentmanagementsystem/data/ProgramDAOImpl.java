package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Program;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.ProgramQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

  @Override
  public void addProgram(Program program) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.INSERT_PROGRAM);
      preparedStatement.setString(1, program.getProgramId());
      preparedStatement.setString(2, program.getProgramName());
      preparedStatement.setInt(3, program.getProgramDuration());
      preparedStatement.setString(4, program.getProgramType());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateProgram(Program program) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.UPDATE_PROGRAM);
      preparedStatement.setString(1, program.getProgramName());
      preparedStatement.setInt(2, program.getProgramDuration());
      preparedStatement.setString(3, program.getProgramType());
      preparedStatement.setString(4, program.getProgramId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteProgram(String programId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.DELETE_PROGRAM);
      preparedStatement.setString(1, programId);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Program getProgramById(String programId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Program program = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.GET_PROGRAM_BY_ID);
      preparedStatement.setString(1, programId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String name = resultSet.getString("programName");
        int duration = resultSet.getInt("programDuration");
        String type = resultSet.getString("programType");

        program = new Program(programId, name, duration, type);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return program;
  }

  @Override
  public List<Program> getAllPrograms() {
    List<Program> programs = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.GET_ALL_PROGRAMS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String programId = resultSet.getString("programId");
        String name = resultSet.getString("programName");
        int duration = resultSet.getInt("programDuration");
        String type = resultSet.getString("programType");

        programs.add(new Program(programId, name, duration, type));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return programs;
  }
}