package main.java.com.studentmanagementsystem.data;
import main.java.com.studentmanagementsystem.model.Authorities;

/**
 * The `AuthoritiesDAO` interface defines the contract for performing CRUD operations
 * on authority records in the database.
 */
public interface AuthoritiesDAO {

  /**
   * Adds a new authority record to the database.
   *
   * @param authority The `Authorities` object representing the authority to be added.
   */
  void addAuthority(Authorities authority);

  /**
   * Updates an existing authority record in the database.
   *
   * @param authority The `Authorities` object representing the updated authority information.
   */
  void updateAuthority(Authorities authority);

  /**
   * Deletes an authority record from the database based on the authority name.
   *
   * @param authorityName The name of the authority to be deleted.
   */
  void deleteAuthority(String authorityName);

  /**
   * Retrieves an authority record from the database based on the authority name.
   *
   * @param authorityName The name of the authority to retrieve.
   * @return The `Authorities` object representing the retrieved authority, or null if not found.
   */
  Authorities getAuthorityByName(String authorityName);
}
