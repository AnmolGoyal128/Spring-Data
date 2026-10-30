package in.springBoot.Hibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 100

    )
    private String name;
    @Column(unique = true, nullable = false, length = 100,
    insertable = true, updatable = false)

    private String email;
    private int age;

    @Column(precision = 5, scale = 2)
    private BigDecimal percentage;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    private LocalDate dateOfBirth;

    private LocalDateTime createAt;

    @Lob // very big object store
    private String profileDescription;

    @Transient // not available in database
    private String displayName;

    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isMonitor;


    @Embedded
    private Address currentaddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseName",
                    column = @Column(name = "permanent_house_name")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "permanent_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "permanent_state")
            ),
            @AttributeOverride(
                    name = "pinCode",
                    column = @Column(name = "permanent_pin_code")
            )
    })
    private Address permanenetAddress;


    @ElementCollection
    @CollectionTable(
            name = "student_skill",
            joinColumns = @JoinColumn(name = "student_id")

    )
    private Set<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "student_address",
            joinColumns = @JoinColumn(name = "Student_id")
    )
    private Set<Address> addresses;


    public Student(){} // Default Constructor

    public Student(Long id,
                   String name,
                   String email,
                   int age,
                   BigDecimal percentage,
                   StudentStatus status,
                   LocalDate dateOfBirth,
                   LocalDateTime createAt,
                   String profileDescription,
                   String displayName,
                   Boolean isMonitor,
                   Address currentaddress,
                   Address permanenetAddress,
                   Set<String> skills,
                   Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.percentage = percentage;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
        this.profileDescription = profileDescription;
        this.displayName = displayName;
        this.isMonitor = isMonitor;
        this.currentaddress = currentaddress;
        this.permanenetAddress = permanenetAddress;
        this.skills = skills;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getMonitor() {
        return isMonitor;
    }

    public void setMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public Address getCurrentaddress() {
        return currentaddress;
    }

    public void setCurrentaddress(Address currentaddress) {
        this.currentaddress = currentaddress;
    }

    public Address getPermanenetAddress() {
        return permanenetAddress;
    }

    public void setPermanenetAddress(Address permanenetAddress) {
        this.permanenetAddress = permanenetAddress;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
