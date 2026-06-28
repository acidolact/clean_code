// Листинг 10.1 SuperDashboard — Слишком много ответственностей
//
// Этот класс имеет слишком много ответственностей. Имя класса туманное,
// что свидетельствует о нежелательном объединении ответственностей.
//
// Классы должны иметь одну ответственность, то есть одну причину для
// изменения. Небольшой, казалось бы, класс SuperDashboard в листинг 10.2
// имеет две причины для изменений.
//

public class SuperDashboard extends JFrame implements MetaDataUser {

  public String getCustomizerLanguagePath() {}
  public void setSystemConfigPath(String systemConfigPath) {}
  public String getSystemConfigDocument() {}
  public void setSystemConfigDocument(String systemConfigDocument) {}
  public boolean getGuruState() {}
  public boolean getNoviceState() {}
  public boolean getOpenSourceState() {}
  public void showObject(MetaObject object) {}
  public void showProgress(String s) {}
  public boolean isMetadataDirty() {}
  public void setIsMetadataDirty(boolean isMetadataDirty) {}
  public Component getLastFocusedComponent() {}
  public void setLastFocused(Component lastFocused) {}
  public void setMouseSelectState(boolean isMouseSelected) {}
  public boolean isMouseSelected() {}
  public LanguageManager getLanguageManager() {}
  public Project getProject() {}
  public Project getFirstProject() {}
  public Project getLastProject() {}
  public String getNewProjectName() {}
  public void setComponentSizes(Dimension dim) {}
  public String getCurrentDir() {}
  public void setCurrentDir(String newDir) {}
  public void updateStatus(int dotPos, int markPos) {}
  public Class[] getDataBaseClasses() {}
  public MetadataFeeder getMetadataFeeder() {}
  public void addProject(Project project) {}
  public boolean setCurrentProject(Project project) {}
  public boolean removeProject(Project project) {}
  public MetaProjectHeader getProgramMetadata() {}
  public void resetDashboard() {}
  public Project loadProject(String fileName, String projectName) {}
  public void setCanSaveMetadata(boolean canSave) {}
  public MetaObject getSelectedObject() {}
  public void deselectObjects() {}
  public void setProject(Project project) {}
  public void editorAction(String actionName, ActionEvent event) {}
  public void setMode(int mode) {}
  public FileManager getFileManager() {}
  public void setFileManager(FileManager fileManager) {}
  public ConfigManager getConfigManager() {}
  public void setConfigManager(ConfigManager configManager) {}
  public ClassLoader getClassLoader() {}
  public void setClassLoader(ClassLoader classLoader) {}
  public Properties getProps() {}
  public String getUserHome() {}
  public String getBaseDir() {}
  public int getMajorVersionNumber() {}
  public int getMinorVersionNumber() {}
  public int getBuildNumber() {}
}

class JFrame {}
class MetaDataUser {}
class MetaObject {}
class Component {}
class Dimension {}
class LanguageManager {}
class Project {}
class MetaProjectHeader {}
class ActionEvent {}
class FileManager {}
class ConfigManager {}
class ClassLoader {}
class Properties {}
