job('NodeJS Docker example') {
    scm {
        git('git://github.com/alexpalitzky1/docker-cicd.git','master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('alexpalitzky1/cicd-app')
            buildContext('basics')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('00293142-bacf-45d1-8d84-c5dcbce5ba75')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
