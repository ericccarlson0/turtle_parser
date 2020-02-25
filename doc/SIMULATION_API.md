### (doc/SIMULATION_API.md) Cell Society Review

* **should be part of internal**: 
Controller Class:
    * ```public Document parseXmlFile(File xmlDoc) ```
    * ```public void cycleCellState(int i, int j) ```
    * ```public void updateGrid() ```
    * ```public void readParamsAndInitialize(Document doc) ```
    * ```public void saveAsXml() ```


* **should be part of external**: 
* Controller Class:
    * ```public List<String> getCellStates()```
    * ```public String getCellState(int i, int j)``` 
    * ```public int getGridWidth() ```
    * ```public int getGridHeight() ```
    

* **should not be part of API**: 
* visualizer Class
    *  ```public visualizer(Stage stage, Controller controller, String language) ```
    * ```public void step(double elapsedTime) ```
    * ```public Scene makeScene(int width, int height) throws Throwable ```




**External Grid Update API**
----
  <_This API call allows external sources to update the grid to next state and receive the updated grid's structure._>


* **Method:**
  
  `GET`
  
* **Data Params**

  <_ String[][] grid_>

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{ grid : [[][]....] }`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "Log in" }`
   
   
   * **Code:** CORRUPT XML FILE <br />
      **Content:** `{ error : "Change XML input." }`


* **Sample Call:**

  <_Update()_> 
  
  
**Internal Add Simulation API**
----
  <_This API call allows adding new simulation type._>


* **Method:**
  
   `PUT`
  
* **Data Params**

  <_ String simulationName_>
  <_ RulesObject RulesSet_>

* **Success Response:**
  
  * **Code:** 100 <br />
    **Content:** `{Message: "New Simulation %simulationName is created.}`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "Rules does not is empty" }`
   
   
   * **Code:** CORRUPT XML FILE <br />
      **Content:** `{ error : "There is an existing simulation with the same name"}`


* **Sample Call:**

  <_addSimulation("NameOfSimulation")_> 
