package com.gsicommerce.jibx.intellij;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

/**
 * @author brodericke
 */
public class AddMappingAction extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        PsiFile psiBinding = event.getData(LangDataKeys.PSI_FILE);
        Module module = event.getData(LangDataKeys.MODULE);
        if (psiBinding == null)
            return;
        VirtualFile binding = psiBinding.getVirtualFile();
        if (binding == null)
            return;
        assert module != null;
        BindingCompilerModuleComponent compiler = module.getComponent(BindingCompilerModuleComponent.class);
        compiler.addBinding(binding);

        System.out.println("added jibx binding: " + binding.getPath());
    }
}
