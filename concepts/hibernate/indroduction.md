# Hibenrate

Everything is object
You may store it in file 
But to manage this data we ahave RDBMS.

Connect your object with DB , you need something to relate : ORM

Acchive OOPs conepts on database , ORM eg . hibernate , ibatis

# Preqeuistes:

Java
SQL

## Saving Object in hibernate

use save()
session.save()

we get this session forom SessionFactory where configuration is defined - XML , JAava Bean

While initalizing  SessionFactory you need to define a drivername, username  password 

same way you can get values as well session.get() 


# Hbm2ddl property:

# Annotations in Hibernate

@Entity : defines a new entity @Entity(name="custom_table_name")
@Id :  for Id
@Column :  for column name
@Transient: if you want to keep a varibale away from ORM. No column will be created
@Embeddedable: For Example Address field may have street, house number, and others
then you create a class Address wiith @Embeddedable annotation. then field adress in main Entity will add all columns from 
Address class to main Entity.

# Relations in Hibernate:

@One to One :   Extra column will be created in the DriverClass. example define an object Laptop in Student class. and use @OneToOne annotion. This will create a mapping of one to one between laptop and strudent.One extra column will be added in strudent table  as 'laptop_lid', to store the mapping And No Exata table will be created 

**@OneToMany : **   Extra table will be created use mappedby to avoid. example student_laptop.
**@ManyTtoOne : **  2 Extra table will be crewated , use mappedby to avoid -only 1 now

Ref: https://www.youtube.com/watch?v=VLlDaIcb3jE&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r&index=13
Practival CREF : https://www.youtube.com/watch?v=8mUPvdDGoLQ&index=14&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r




