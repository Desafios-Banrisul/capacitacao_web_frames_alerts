package TestSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/* Nota

Nas versões do Junit 5.8 em diante este formato de criação de suites não funciona mais, é necessario importar
junit-platform-suite-engine para funcionar o runner (esta no pom como exemplo), abaixo exemplo da mudança:

@Suite
@SelectPackages("TestCases.Frames")

 */

@RunWith(JUnitPlatform.class)
@SelectPackages("TestCases.Frames")
public class AllTestsFrames {
}

