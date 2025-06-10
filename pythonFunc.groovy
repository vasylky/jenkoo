pipelineJob('MyPythonFunc') {
    description('Pipeline for MyProject')
    parameters {
        stringParam('PROJECT_NAME', 'PyProject', 'Name of the project')
        stringParam('VERSION', '1.2.0', 'Version of the project')
        choiceParam('BRANCH_NAME', ['main', 'feature/test'], 'Git branch to build')
        stringParam('NUM1', '5', 'First number')
        stringParam('NUM2', '10', 'Second number')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/vasylky/jenkoo.git')
                    }
                    branch('${BRANCH_NAME}')
                }
                scriptPath('pythonFunc.jenkinsfile')
            }
        }
    }
}
