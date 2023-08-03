package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Program;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.ProgramQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ProgramDAOImpl class implements the ProgramDAO interface and provides
 * methods to interact with the database for Program entities.
 */
public class ProgramDAOImpl implements ProgramDAO {

  private DatabaseManager databaseManager;

  public ProgramDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addProgram(Program program) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.INSERT_PROGRAM);

      preparedStatement.setInt(1, program.getProgramId());
      preparedStatement.setString(2, program.getProgramName());
      preparedStatement.setString(3, program.getProgramDuration());
      preparedStatement.setString(4, program.getProgramType());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateProgram(Program program) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.UPDATE_PROGRAM);

      preparedStatement.setString(1, program.getProgramName());
      preparedStatement.setString(2, program.getProgramDuration());
      preparedStatement.setString(3, program.getProgramType());
      preparedStatement.setInt(4, program.getProgramId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteProgram(int programId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.DELETE_PROGRAM);

      preparedStatement.setInt(1, programId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Program getProgramById(int programId) {
    Program program = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.GET_PROGRAM_BY_ID);

      preparedStatement.setInt(1, programId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        program = extractProgramFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
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
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ProgramQueryConstants.GET_ALL_PROGRAMS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Program program = extractProgramFromResultSet(resultSet);
        programs.add(program);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return programs;
  }

  private Program extractProgramFromResultSet(ResultSet resultSet) throws SQLException {
    int programId = resultSet.getInt("P_ID");
    String programName = resultSet.getString("P_name");
    String programDuration = resultSet.getString("P_duration");
    String programType = resultSet.getString("P_type");

    return new Program(programId, programName, programDuration, programType);
  }
}
