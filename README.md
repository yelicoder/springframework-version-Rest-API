# springframework-version-Rest-API
Code and Notes from studying Pluralsight course: Spring Framework: Versioning Spring Data REST APIs by Craig Golightly

### Module 1
Implementation of a PagingAndSortingRepository

### API versioning Strategies
* URI
  - version is embedded in URI, usually near root.
  - Works with caching where URI is key
  - Creates whole new tree with each version
* Media type
  - Define vendor specific media types
  - Used server side to determine what version to use for call
  - URI does not change
  - Non-standard media types can be confusing
* Custom header
  - Define a custom header for version information: ```Accept-version: v1```
  - Userd server side to determine what version to use for call
  - URI does not change
  - More clear than media type
* Request parameter
  - Define a version parameter
  - Parsed out with other parameters to determine what version to use for call
  - URI does not change
  - Routing can be mofe difficult than other versioning strategies
* No strategy
  - Simplifies server-side logic
  - Clients doon't need to know any special header ibnformation
  - If need a version inthe future, jsut add one - exising becomes "old" default
### URI Versioning
* spring.data.rest.basePath=/v2 in applicaiton.properties automatically adds the version number managed by Spring Data
  - Need add the spring-data-rest dependency
* @BasePathAwareController add to include basePath in any @RequestMapping that are not managed by Spring Data
  - Need add the spring-date-rest dependency to have this annotation working
  - both the /v2 version and the version without version number work
  ```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
  </dependency>
  ```
### Module 2
* No controllers
* Only an Employee model and an EmployeeRepository extends JpaRepository or PagingAndSortingRepository, Spring boot automatically generated the REST APIs to the Employee entity as long as data-rest starter dependency is in pom.xml
### Managing API versions
* group breaking changes into a single release
* Major version - breaking changes. minor version - non-breaking changes
* Set end-of-life date for previous version
* Consider if back end data store changes
* Consider how the client switch
* Anti-patterns
  - versions in class name
  - mapping out all CRUD methods
* maximize what the framework can do for you
* Version 1 and Version 2 should be in different branches. One artifact per version

## Custom Header Versioning
* add value for headers in @RequestMapping
```
@RequestMapping(value="/schedule", method= RequestMethod.GET, headers="Accept-version=v2")
```
* Not for spring-data-rest managed entity
* Better to have a load balancer to check the header and redirect to the correpsonding instance


